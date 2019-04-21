import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Main implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame( "CheerpJ Demo" );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 400, 80 );
        frame.add( new Counter() );
        frame.setVisible( true );
    }

    public static void main( String[] args ) {
        SwingUtilities.invokeLater( new Main() );
    }
}

class Counter extends JPanel {
    private int value;

    public Counter() {
        JButton up = new JButton( "Increment" );
        JButton down = new JButton( "Decrement" );
        JLabel out = new JLabel();

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

        up.addActionListener( event -> handler.accept( true ) );
        down.addActionListener( event -> handler.accept( false ) );

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add( up );
        buttonsPanel.add( down );

        JLabel title = new JLabel( "CheerpJ CounterApp (Swing)" );

        setLayout( new BorderLayout() );
        add( title, BorderLayout.PAGE_START );
        add( buttonsPanel, BorderLayout.PAGE_END );
        add( out, BorderLayout.CENTER );
    }
}
