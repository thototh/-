import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Omok extends JFrame {    
	Board board[][];
    private Judge judge;
	ImageIcon img = new ImageIcon("img/empty.png");
	ImageIcon white = new ImageIcon("img/white.png");
	ImageIcon black = new ImageIcon("img/black.png");
	ImageIcon turn = black;
    final int SIZE = 20;    // size of Board

	public Omok() {
		Container c = getContentPane();
		c.setLayout(new GridLayout(SIZE, SIZE));
		board = new Board[SIZE][];
		myActionListener goAction = new myActionListener();

		for (int i = 0; i < SIZE; i++) {
			board[i] = new Board[SIZE];

			for (int j = 0; j < SIZE; j++) {
				board[i][j] = new Board(i, j, img);
				c.add(board[i][j]);
				board[i][j].addActionListener(goAction);
				board[i][j].setBorderPainted(false);
			}
		}

        judge = new Judge(board);

		setTitle("Omok");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SIZE * 40, SIZE * 40);
		setVisible(true);
	}

	class myActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Board board = (Board) e.getSource();
			if (turn == white) {
				board.setIcon(white);
				board.state = 'W';
				turn = black;
			} else {
				board.setIcon(black);
				board.state = 'B';
				turn = white;
			}
            if (judge.checkWin(board)) {
                if (board.state == 'B') {  // if black wins
                    JOptionPane.showMessageDialog(null, "BLACK WINS!", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                } else {    // if white wins
                    JOptionPane.showMessageDialog(null, "WHITE WINS!", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                }
            }
			board.removeActionListener(this);
		}
	}
}
