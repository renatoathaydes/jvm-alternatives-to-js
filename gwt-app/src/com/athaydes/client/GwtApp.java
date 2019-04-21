package com.athaydes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

import java.util.function.Consumer;

public class GwtApp implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get( "content" ).add( new Counter() );
    }
}

class Counter extends Composite {

    private int value;

    Counter() {
        HorizontalPanel buttonsPanel = new HorizontalPanel();
        buttonsPanel.setSpacing( 10 );

        Button up = new Button( "Increment" );
        Button down = new Button( "Decrement" );
        Label out = new Label();

        Runnable update = () -> out.setText( "The current count is " + value );
        update.run();

        Consumer<Boolean> handler = ( increment ) -> {
            if ( increment ) {
                value++;
            } else {
                value--;
            }
            update.run();
        };

        up.addClickHandler( clickEvent -> handler.accept( true ) );
        down.addClickHandler( clickEvent -> handler.accept( false ) );

        buttonsPanel.add( up );
        buttonsPanel.add( down );

        VerticalPanel root = new VerticalPanel();
        root.setSpacing( 20 );

        root.add( out );
        root.add( buttonsPanel );

        initWidget( root );
    }

}