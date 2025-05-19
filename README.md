# 🔦 Lights Out Solver & Game Board (Java)

## 🧩 Overview

This project implements both a **playable version** of the classic *Lights Out* puzzle game and a **solver** using **Breadth-First Search (BFS)**. The solver explores over **4 million board states**, using a **HashMap** for memoization to avoid redundant calculations and ensure efficient state tracking.

Lights Out is a logic puzzle with a grid of lights that can be turned on or off. Pressing a light toggles it and its adjacent neighbors. The goal is to turn off all lights.

## 🛠 Technologies Used

- Java
- Object-Oriented Programming
- Breadth-First Search (BFS)
- HashMap for state caching
- Custom game board implementation

## 📌 Features

- ✅ Fully playable game board UI (console or GUI depending on your implementation)
- 🔍 BFS-based solver to find the shortest sequence of moves to solve any board state
- 🧠 Memoization using `HashMap` to cache visited states and avoid recomputation
- 🚀 Efficient exploration of 4M+ board paths for large-scale solving
- 🧪 Easily customizable for different board sizes

## ⚙️ How It Works

### Solver Logic (BFS)

1. **Initial State:** Take a board configuration as input.
2. **Breadth-First Search:** Traverse all possible sequences of moves.
3. **Memoization:** Use a `HashMap<String, Boolean>` to track visited states by encoding board layouts.
4. **Goal:** Find the shortest move sequence that leads to all lights being off.

### Game Logic

- Clicking or toggling a light flips it and its adjacent lights.
- Game supports board resets and custom start states.

## 🧪 Example

**Starting Board (5x5)**  
O O O O O

O X X X O

O X O X O

O X X X O

O O O O O


**Solver Output:**  
Solution found in 9 moves:
(2,2), (1,1), (1,3), ...



