package nl.papendorp.template;

import nl.papendorp.template.testing.shared.logging.AppenderSpy;
import org.apache.logging.log4j.core.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.hamcrest.Matchers.contains;

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
	@DisplayName( "log its first command line argument" )
	void app_logs_first_argument()
	{
		Main.main( "Test" );

		MatcherAssert.assertThat( appender.messages(), contains( "Hello, Test" ) );
	}

	@Test
	@DisplayName( "log all its command line arguments" )
	void app_logs_all_arguments()
	{
		Main.main( "test", "suite" );

		MatcherAssert.assertThat( appender.messages(), contains( "Hello, test and suite" ) );
	}

	@AfterEach
	void tearDown()
	{
		((Logger) getLogger( Main.class ))
				.removeAppender( appender );
		appender.stop();
	}
}
