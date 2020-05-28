package nl.papendorp.template;

import nl.papendorp.testing.shared.logging.AppenderSpy;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName( "This app should" )
class MainSuite
{
	private AppenderSpy appender;

	@BeforeEach
	void setUp()
	{
		appender = new AppenderSpy();
		((Logger) getLogger( Main.class ))
			.addAppender( appender );
	}

	@Test
	@DisplayName( "log its command line arguments." )
	void app_logs_arguments()
	{
		new Main().main( "Test" );
		Main.main( "test", "suite" );

		assertThat( appender.messages(), contains( "Hello, Test!", "Hello, test and suite!" ) );
	}

	@Test
	@DisplayName( "provide default when no arguments are supplied." )
	void provide_default()
	{
		Main.main();
		assertThat( appender.messages(), contains( "Hello, there!" ) );
	}

	@Test
	@DisplayName( "reject nulls." )
	void reject_nulls()
	{
		assertThrows( IllegalArgumentException.class, () -> Main.main( null ) );
	}

	@AfterEach
	void tearDown()
	{
		((Logger) getLogger( Main.class ))
			.removeAppender( appender );
		appender.stop();
	}
}
