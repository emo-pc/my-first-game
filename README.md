# 🚀 2042 Interceptor — 2D Space Shooter Game

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![StdDraw](https://img.shields.io/badge/Library-StdDraw-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A 2D space shooter arcade game developed in Java using the **StdDraw** library. Developed for **Boğaziçi University CMPE 160 (Object-Oriented Programming)**. 

The game features dynamic multi-layer enemy formations, custom bounding-box collision physics, and complex mathematical AI movement patterns for unique boss villains.

---

## 🎬 Gameplay Demo & Videos

- 🎥 **Main Game Preview:** [Watch on YouTube Shorts](https://youtube.com/shorts/QOm7izfwYWU)
- 🚀 **Bonus Boss Villains Showcase:** [Watch on YouTube Shorts](https://youtube.com/shorts/D8PU5rhMqjI)

---

## 🎮 Game Features & Mechanics

### 1. Core Gameplay & Controls
- **Main Menu & Settings:** Custom FPS and game speed controls before starting.
- **Player Mechanics:** Full 2D movement (Up, Down, Left, Right) and shooting.
- **Health & Drops:** Exploding enemies have a chance to drop health power-ups.
- **Synchronized Layers:** Enemies move in synchronized horizontal layers, bouncing off screen borders dynamically.
- **Axis-Aligned Collision Detection:** Custom rectangular boundary algorithms calculating Euclidean distances for precise hit detection.

### 👾 Bonus Bosses & Advanced AI Mechanics
The game includes **6 custom villain types**, each implemented with unique mathematical trajectories and projectile mechanics:

| Villain | Movement Trajectory | Projectile / Unique Behavior |
| :--- | :--- | :--- |
| **Villain 1** | Probabilistic Y-axis movement | Random Y-velocity bullets; can destroy player bullets mid-air. |
| **Villain 2** | Zig-zag pathing | Burst-fire mechanism (stops & fires 4 consecutive bullets). |
| **Bananini** | Parabolic curve: $y = \frac{(x-900)^2}{750} + 750$ | Sinusoidal wave bullets: $x = k + 100 \sin(y)$. |
| **Turretle** | Circular orbit: $(x-a)^2 + (y-b)^2 = 10000$ | Orbital projectiles. |
| **BeetleJuice** | **Bullet Dodging Vector AI:** Calculates inverse-distance escape vectors when player bullets get within 200 units. | Homing/accelerating bullets targeting player location. |
| **Goblin** | Infinity ($\infty$) loop path: $x = 600 + 450\sin(t)$, $y = 1300 + 150\sin(2t)$ | Cubic trajectory bullets ($y = \pm x^3$). |

---

## 🕹️ Controls

| Key | Action |
| :--- | :--- |
| `W / A / S / D` or `Arrow Keys` | Move Interceptor Ship |
| `Space` | Fire Bullet |
| `Enter` | Confirm / Start Game / Restart |
| `Up / Down` | Navigate End Game Menu |

---
## 🚀 How to Run Locally

### Prerequisites
- Java Development Kit (JDK 11 or higher) installed.

### Execution
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/emo-pc/my-first-game.git](https://github.com/emo-pc/my-first-game.git)
   cd my-first-game
   ```

2. **Compile and Run:**
   !!Important: Upload `stdlib.jar` library and set it.
   Make sure you have the assets.
   Ensure `stdlib.jar` is in your working directory, then run:
   ```bash
   javac -cp .:stdlib.jar src/*.java -d bin
   java -cp bin:stdlib.jar Main
   ```
---
## 👤 Author

<a href="https://github.com/emo-pc">
  <img src="picture.png" width="150" align="right" alt="Emre Ezgü Ghibli Portrait">
</a>

**Emre Ezgü**  
- **University:** Bogazici University — Computer Engineering
- **GitHub:** [@emo-pc](https://github.com/emo-pc)
