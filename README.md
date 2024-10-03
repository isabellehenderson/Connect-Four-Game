# Connect Four Game

This project implements a classic Connect Four game as part of an abstract strategy game framework. It provides a command-line interface for two players to compete against each other.

## Features

- **Interactive Gameplay**: Players take turns dropping discs into a 7x6 grid.
- **Win Detection**: Automatically detects winning combinations (horizontal, vertical, diagonal).
- **Tie Detection**: Recognizes when the board is full with no winner.
- **Input Validation**: Prevents illegal moves and provides error messages.

## Project Structure

The project consists of three main Java files:

1. `ConnectFour.java`: Implements the game logic and board representation.
2. `AbstractStrategyGame.java`: Defines the interface for strategy games.
3. `Client.java`: Provides the main game loop and user interaction.

## Getting Started

To run the Connect Four game:

1. Compile all Java files in the project.
2. Run the `Client` class.

```bash
javac *.java
java Client
```

## How to Play

1. The game starts with Player 1 (R) taking the first turn.
2. Players alternate turns, choosing a column (0-6) to drop their disc.
3. The game ends when a player connects four discs in a row (horizontally, vertically, or diagonally) or the board is full (tie).

## Game Rules

- Player 1 uses red discs (R), Player 2 uses yellow discs (Y).
- Discs fall to the lowest available space in the chosen column.
- The game board is displayed after each move.
- Invalid moves (e.g., full column) are prevented and prompt for a new input.

## Implementation Details

- The `ConnectFour` class implements the `AbstractStrategyGame` interface.
- The game board is represented as a 2D char array.
- Win checking algorithms cover all possible winning combinations.
- The `Client` class handles the main game loop and exception handling for illegal moves.