package com.example.test;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.function.Consumer;

@Route( "" )
public class MainView extends VerticalLayout {

    public MainView() {
        H2 header = new H2( "Vaadin Flow CounterApp" );
        add( header, new Counter() );
    }
}

class Counter extends Composite<Div> {
    private int value;

    Counter() {
        Paragraph out = new Paragraph();
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

        Button up = new Button( "Increment", event -> handler.accept( true ) );
        Button down = new Button( "Decrement", event -> handler.accept( false ) );

        getContent().add( out, up, down );
    }
}