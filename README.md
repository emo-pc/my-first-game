# 🚀 2042 Interceptor — 2D Space Shooter Game

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![StdDraw](https://img.shields.io/badge/Library-StdDraw-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A 2D space shooter arcade game developed in Java using the **StdDraw** library. Developed for **Boğaziçi University CMPE 160 (Object-Oriented Programming)**. 

The game features dynamic multi-layer enemy formations, custom bounding-box collision physics, and complex mathematical AI movement patterns for unique boss villains.

---

## 🎬 Gameplay Demo & Videos

- 🎥 **Main Game Preview:** [Watch on YouTube Shorts](https://youtube.com/shorts/QOm7izfwYWU)[cite: 1]
- 🚀 **Bonus Boss Villains Showcase:** [Watch on YouTube Shorts](https://youtube.com/shorts/D8PU5rhMqjI)[cite: 1]

---

## 🎮 Game Features & Mechanics

### 1. Core Gameplay & Controls
- **Main Menu & Settings:** Custom FPS and game speed controls before starting[cite: 1].
- **Player Mechanics:** Full 2D movement (Up, Down, Left, Right) and shooting[cite: 1].
- **Health & Drops:** Exploding enemies have a chance to drop health power-ups[cite: 1].
- **Synchronized Layers:** Enemies move in synchronized horizontal layers, bouncing off screen borders dynamically[cite: 1].
- **Axis-Aligned Collision Detection:** Custom rectangular boundary algorithms calculating Euclidean distances for precise hit detection[cite: 1].

### 👾 Bonus Bosses & Advanced AI Mechanics
The game includes **6 custom villain types**, each implemented with unique mathematical trajectories and projectile mechanics[cite: 1]:

| Villain | Movement Trajectory | Projectile / Unique Behavior |
| :--- | :--- | :--- |
| **Villain 1** | Probabilistic Y-axis movement[cite: 1] | Random Y-velocity bullets; can destroy player bullets mid-air[cite: 1]. |
| **Villain 2** | Zig-zag pathing[cite: 1] | Burst-fire mechanism (stops & fires 4 consecutive bullets)[cite: 1]. |
| **Bananini** | Parabolic curve: $y = \frac{(x-900)^2}{750} + 750$[cite: 1] | Sinusoidal wave bullets: $x = k + 100 \sin(y)$[cite: 1]. |
| **Turretle** | Circular orbit: $(x-a)^2 + (y-b)^2 = 10000$[cite: 1] | Orbital projectiles[cite: 1]. |
| **BeetleJuice** | **Bullet Dodging Vector AI:** Calculates inverse-distance escape vectors when player bullets get within 200 units[cite: 1]. | Homing/accelerating bullets targeting player location[cite: 1]. |
| **Goblin** | Infinity ($\infty$) loop path: $x = 600 + 450\sin(t)$, $y = 1300 + 150\sin(2t)$[cite: 1] | Cubic trajectory bullets ($y = \pm x^3$)[cite: 1]. |

---

## 🕹️ Controls

| Key | Action |
| :--- | :--- |
| `W / A / S / D` or `Arrow Keys` | Move Interceptor Ship[cite: 1] |
| `Space` | Fire Bullet[cite: 1] |
| `Enter` | Confirm / Start Game / Restart[cite: 1] |
| `Up / Down` | Navigate End Game Menu[cite: 1] |

---

## 🛠️ Technical Implementation & Math

```java
// Example: BeetleJuice Bullet Dodging AI Algorithm
if (totalDistance < 200) {
    double force = (200 - totalDistance) / 200;
    escapeX += (horizontalDist / totalDistance) * force * 11;
    escapeY += (verticalDist / totalDistance) * force * 8;
}
