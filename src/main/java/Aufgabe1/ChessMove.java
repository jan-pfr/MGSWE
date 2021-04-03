package Aufgabe1;

public class ChessMove {
    private String moveID;
    private String whiteMove;
    private String blackMove;

    public String getID() { return moveID; }

    public void setID(String moveID) { this.moveID = moveID.trim(); }

    public String getWhiteMove() { return whiteMove; }

    public void setWhiteMove(String whiteMove) { this.whiteMove = whiteMove.trim(); }

    public String getBlackMove() { return blackMove; }

    public void setBlackMove(String blackMove) { this.blackMove = blackMove.trim(); }

    @Override
    public String toString() {

        return "ChessMove{" +
                "moveID='" + moveID + '\'' +
                ", whiteMove='" + whiteMove + '\'' +
                ", blackMove='" + blackMove + '\'' +
                '}';
    }
}
