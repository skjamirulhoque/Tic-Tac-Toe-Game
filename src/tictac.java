import java.awt.*;
import java.awt.event.*;
import  java.util.*;
import javax.swing.*;
import java.util.Random;

 class tictac  extends JFrame implements ActionListener
 {
    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    JButton exit,restart;

    tictac() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocation(300,0);


        getContentPane().setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());
        setVisible(true);

        //
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac_Toe");
        textfield.setOpaque(true);
        //
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textfield);
        add(title_panel, BorderLayout.NORTH);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        add(button_panel);


        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        //exit button
        exit=new JButton("Exit");
        exit.setBounds(300,350,230,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.green);
        exit.setFont(new Font("Ink Free",Font.BOLD,25));
        exit.addActionListener(this);

        //restart button
        restart=new JButton("Restart");
        restart.setBounds(300,450,230,30);
        restart.setBackground(Color.BLACK);
        restart.setForeground(Color.green);
        restart.setFont(new Font("Ink Free",Font.BOLD,25));
        restart.addActionListener(this);

        //
        JPanel ButtonPanel=new JPanel();
        ButtonPanel.setLayout(new GridLayout(1,2));
        ButtonPanel.add(exit);
        ButtonPanel.add(restart);

        JPanel title_panel2=new JPanel();
        title_panel2.setLayout(new BorderLayout());
        title_panel2.setBounds(0,800,650,80);
        title_panel2.add(ButtonPanel);
        add(title_panel2,BorderLayout.SOUTH);
        //
        firstTurn();

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if(e.getSource()==restart)
        {
            setVisible(false);
            new tictac();
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");

        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check()
    {
        //check X wins condition
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X"))
        {
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X")&& (buttons[4].getText()=="X")&&(buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X")&& (buttons[5].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X"))
        {
            xWins(2,4,6);
        }


        //checks O wins condition
        if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O"))
        {
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O"))
        {
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O"))
        {
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O")&& (buttons[5].getText()=="O")&& (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O")&& (buttons[4].getText()=="O")&& (buttons[8].getText()=="O"))
        {
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O")&& (buttons[4].getText()=="O")&& (buttons[6].getText()=="O"))
        {
            oWins(2,4,6);
        }
        checkForTie();
    }

    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");

    }

    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }
     public boolean checkForWin(char player)
     {
         // Check horizontal lines
         if ((buttons[0].getText().charAt(0) == player && buttons[1].getText().charAt(0) == player && buttons[2].getText().charAt(0) == player) ||
                 (buttons[3].getText().charAt(0) == player && buttons[4].getText().charAt(0) == player && buttons[5].getText().charAt(0) == player) ||
                 (buttons[6].getText().charAt(0) == player && buttons[7].getText().charAt(0) == player && buttons[8].getText().charAt(0) == player)) {
             return true; // Horizontal win
         }

         // Check vertical lines
         if ((buttons[0].getText().charAt(0) == player && buttons[3].getText().charAt(0) == player && buttons[6].getText().charAt(0) == player) ||
                 (buttons[1].getText().charAt(0) == player && buttons[4].getText().charAt(0) == player && buttons[7].getText().charAt(0) == player) ||
                 (buttons[2].getText().charAt(0) == player && buttons[5].getText().charAt(0) == player && buttons[8].getText().charAt(0) == player)) {
             return true; // Vertical win
         }

         // Check diagonal lines
         if ((buttons[0].getText().charAt(0) == player && buttons[4].getText().charAt(0) == player && buttons[8].getText().charAt(0) == player) ||
                 (buttons[2].getText().charAt(0) == player && buttons[4].getText().charAt(0) == player && buttons[6].getText().charAt(0) == player)) {
             return true; // Diagonal win
         }

         return false; // No win
     }

     public void checkForTie() {
         boolean allCellsFilled = true;
         // Check if any cell is empty
         for (int i = 0; i < 9; i++) {
             if (buttons[i].getText().isEmpty()) {
                 allCellsFilled = false;
                 break;
             }
         }
         // Check if no player has won
         if (allCellsFilled && !checkForWin('X') && !checkForWin('O')) {
             // All cells are filled and no player has won, declare a tie
             textfield.setText("It's a tie!");
         }
     }
}

 
 

