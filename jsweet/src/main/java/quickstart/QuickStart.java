package quickstart;

import def.dom.HTMLButtonElement;
import def.dom.HTMLElement;

import java.util.function.Consumer;

import static def.dom.Globals.document;

public class QuickStart {
    public static void main( String[] args ) {
        HTMLElement div = document.createElement( "h2" );
        div.appendChild( document.createTextNode( "JSweet CounterApp" ) );
        document.body.appendChild( div );
        div.appendChild( new Counter().build() );
    }
}

class Counter {
    private int value = 0;

    HTMLElement build() {
        HTMLButtonElement up = ( HTMLButtonElement ) document.createElement( "button" );
        up.appendChild( document.createTextNode( "Increment" ) );
        HTMLButtonElement down = ( HTMLButtonElement ) document.createElement( "button" );
        down.appendChild( document.createTextNode( "Decrement" ) );
        HTMLElement out = document.createElement( "p" );

        Runnable update = () -> out.innerText = "The current count is " + value;

        Consumer<Boolean> handler = ( increment ) -> {
            if ( increment ) {
                value++;
            } else {
                value--;
            }
            update.run();
        };

        up.onclick = ( event ) -> {
            handler.accept( true );
            return null;
        };
        down.onclick = ( event ) -> {
            handler.accept( false );
            return null;
        };

        update.run();

        HTMLElement div = document.createElement( "div" );
        div.appendChild( out );
        div.appendChild( up );
        div.appendChild( down );

        return div;
    }
}