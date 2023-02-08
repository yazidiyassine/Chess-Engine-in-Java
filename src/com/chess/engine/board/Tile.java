package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

abstract class Tile {

	protected final int tileCoordinate;
	private static Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

	private Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}

	public static Tile createTile(int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
	}

	protected static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		return ImmutableMap.copyOf(emptyTileMap);
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {
		EmptyTile(final int coordinate) {
			super(coordinate);
		}

		@Override
		public boolean isTileOccupied() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Piece getPiece() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public static final class OccupiedTile extends Tile {
		private final Piece pieceOnTile;

		private OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
			super(tileCoordinate);
			this.pieceOnTile = pieceOnTile;
		}

		@Override
		public boolean isTileOccupied() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Piece getPiece() {
			// TODO Auto-generated method stub
			return this.pieceOnTile;
		}
	}

}
