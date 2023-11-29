class Judge {
    private Board[][] board;

    public Judge(Board[][] board) {
        this.board = board;
    }

    public boolean checkWin(Board b) {  // check sequence of 8 ways
        return checkSequence(b, -1, 0) || checkSequence(b, 1, 0) ||
               checkSequence(b, 0, -1) || checkSequence(b, 0, 1) ||
               checkSequence(b, -1, -1) || checkSequence(b, 1, 1) ||
               checkSequence(b, -1, 1) || checkSequence(b, 1, -1);
    }

    private boolean checkSequence(Board b, int dx, int dy) {
        int x = b.x;
        int y = b.y;
        int cnt = 0;

        while (isValid(x, y) && board[x][y].state == b.state) {
            cnt++;
            x += dx;
            y += dy;
        }

        return cnt >= 5;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
