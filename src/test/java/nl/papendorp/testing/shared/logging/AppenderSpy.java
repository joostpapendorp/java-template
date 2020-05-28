package nl.papendorp.testing.shared.logging;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.util.ArrayList;
import java.util.List;

public class AppenderSpy extends AbstractAppender
{
	private final List< String > messages = new ArrayList<>();

	public AppenderSpy()
	{
		super(
				"TestAppender",
				new AbstractFilter()
				{
				},
				PatternLayout.createDefaultLayout(),
				false,
				Property.EMPTY_ARRAY
		);

		this.start();
	}

	@Override
	public void append( LogEvent event )
	{
		messages.add( event.getMessage().getFormattedMessage() );
	}

	public List< String > messages()
	{
		return messages;
	}
}
