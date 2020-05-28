package nl.papendorp.template;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main
{
	public static void main( @NonNull final String... commandLineArguments )
	{
		final var greeted = commandLineArguments.length == 0
			? "there"
			: String.join( " and ", commandLineArguments );

		log.info( "Hello, {}!", greeted );
	}
}
