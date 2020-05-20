package nl.papendorp.template;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main
{
	public static void main( final String... commandLineArguments )
	{
		final var allArguments = String.join( " and ", commandLineArguments );
		log.info( "Hello, {}", allArguments );
	}
}
