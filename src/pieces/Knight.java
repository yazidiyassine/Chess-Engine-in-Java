package pieces;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import board.Alliance;
import board.Board;
import board.Move;
import board.Tile;

public class Knight extends Piece {

	private static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {
		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();
		for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
			candidateDestinationCoordinate = this.piecePosition + currentCandidate;
			if (true /* isValidTileCoordinate */) {
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				if (!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance piceAtAlliance = pieceAtDestination.getPieceAlliance();
					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new Move());
					}
				}

			}
		}

		return ImmutableList.copyOf(legalMoves);
	}

}
