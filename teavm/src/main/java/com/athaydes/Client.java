package com.athaydes;

import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

import java.util.function.Consumer;

public class Client {
    public static void main( String[] args ) {
        HTMLDocument document = HTMLDocument.current();
        HTMLElement div = document.createElement( "h2" );
        div.appendChild( document.createTextNode( "TeaVM CounterApp" ) );
        document.getBody().appendChild( div );
        div.appendChild( new Counter().build() );
    }
}

class Counter {
    private int value = 0;

    HTMLElement build() {
        HTMLDocument document = HTMLDocument.current();
        HTMLButtonElement up = ( HTMLButtonElement ) document.createElement( "button" );
        up.appendChild( document.createTextNode( "Increment" ) );
        HTMLButtonElement down = ( HTMLButtonElement ) document.createElement( "button" );
        down.appendChild( document.createTextNode( "Decrement" ) );
        HTMLElement out = document.createElement( "p" );

        Runnable update = () -> out.setInnerHTML( "The current count is " + value );

        Consumer<Boolean> handler = ( increment ) -> {
            if ( increment ) {
                value++;
            } else {
                value--;
            }
            update.run();
        };

        up.listenClick( ( event ) -> handler.accept( true ) );
        down.listenClick( ( event ) -> handler.accept( false ) );

        update.run();

        HTMLElement div = document.createElement( "div" );
        div.appendChild( out );
        div.appendChild( up );
        div.appendChild( down );

        return div;
    }
}