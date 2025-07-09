# Software Requirements Specification (SRS) for SWRPG Sheet Manager

## 1. Introduction

### 1.1. Purpose
This document outlines the requirements for the Star Wars RPG (FFG/Edge System) Character and Vehicle Sheet Management application. Its purpose is to provide a detailed description of the application's features, behavior, and constraints, serving as a guide for development, testing, and user documentation.

### 1.2. Project Scope
The application will enable users to create, view, edit, and manage digital character and vehicle sheets for the Star Wars Roleplaying system by Fantasy Flight Games (FFG) and Edge Studio. It will also include a specialized dice roller to handle the game's unique dice symbols. The application is intended for use on Android, Windows, and Linux platforms.

### 1.3. Target Audience
The primary users are players and Game Masters (GMs) of the FFG/Edge Star Wars RPG system who want a convenient, digital way to manage their game data.

## 2. Overall Description

### 2.1. Product Perspective
This will be a standalone, cross-platform application built with Kotlin and Compose Multiplatform. It will store user data locally on the device, ensuring offline accessibility.

### 2.2. User Interface (UI/UX) Goals
- **Intuitive and Clean:** The UI will be modern, uncluttered, and easy to navigate, following Material Design principles.
- **Responsive:** The layout will adapt gracefully to different screen sizes, from mobile phones to large desktop monitors.
- **Thematic:** The design will incorporate a subtle Star Wars aesthetic (e.g., color schemes, fonts, icons) without sacrificing usability.

## 3. Functional Requirements

### 3.1. Character Sheet Management
- **FR1.1: Create Character:** Users can create a new character sheet, which includes fields for:
    - Basic Information: Name, Species, Career, Specialization(s).
    - Characteristics: Brawn, Agility, Intellect, Cunning, Willpower, Presence.
    - Skills: A list of all game skills, with ranks for each.
    - Talents: A list of talents with descriptions.
    - Derived Stats: Soak, Wounds (Threshold/Current), Strain (Threshold/Current), Defense (Ranged/Melee).
    - Motivations, Obligations, Morality.
    - Equipment & Inventory: Weapons, Gear, Credits.
- **FR1.2: View Character:** Users can open and view an existing character sheet. All information should be clearly displayed.
- **FR1.3: Edit Character:** Users can edit all fields on a character sheet. The application will automatically recalculate derived stats where applicable (e.g., Soak from Brawn and armor).
- **FR1.4: Delete Character:** Users can delete a character sheet after a confirmation prompt.
- **FR1.5: List Characters:** The main screen will display a list of all created characters for easy access.

### 3.2. Vehicle Sheet Management
- **FR2.1: Create Vehicle:** Users can create a new vehicle sheet, including:
    - Basic Information: Name, Model, Manufacturer.
    - Characteristics: Silhouette, Speed, Handling.
    - Defenses: Armor, Hull Trauma (Threshold/Current), System Strain (Threshold/Current).
    - Weapons, attachments, and cargo.
- **FR2.2: View/Edit/Delete Vehicle:** Similar to character sheets, users can view, edit, and delete vehicle sheets.
- **FR2.3: List Vehicles:** A separate section of the app will list all created vehicles.

### 3.3. Dice Roller
- **FR3.1: Build Dice Pool:** Users can select the number and type of dice to roll (Ability, Proficiency, Difficulty, Challenge, Boost, Setback, Force).
- **FR3.2: Roll Dice:** The application will simulate the roll and display the raw results on each die face.
- **FR3.3: Calculate Net Results:** The application will automatically cancel opposing symbols (Success vs. Failure, Advantage vs. Threat, Triumph vs. Despair) and display the final net result.
- **FR3.4: Interpret Results:** The final results (e.g., "2 Success, 1 Advantage") will be clearly displayed. Triumph, Despair, and Force Pip results will be highlighted.

### 3.4. Data Management
- **FR4.1: Local Persistence:** All character and vehicle data will be saved locally on the user's device.
- **FR4.2 (Future): Import/Export:** Users will be able to export a character/vehicle sheet to a file (e.g., JSON or XML) and import it on another device.

## 4. Non-Functional Requirements

### 4.1. Performance
- **NFR1.1:** The application should launch quickly and respond smoothly to user input.
- **NFR1.2:** UI transitions and animations should be fluid.
- **NFR1.3:** Dice rolling calculations should be instantaneous.

### 4.2. Usability
- **NFR2.1:** The application must be usable offline.
- **NFR2.2:** Key actions (like rolling dice or updating wounds) should be accessible with minimal taps/clicks.

### 4.3. Platform Support
- **NFR3.1: Android:** Supports Android 8.0 (Oreo) and newer.
- **NFR3.2: Desktop:** Packaged as a native installer for Windows (`.msi` or `.exe`) and Linux (`.deb` or `.AppImage`).

### 4.4. Data Integrity
- **NFR4.1:** The application must ensure that saved data is not corrupted. Changes should be saved automatically or with a clear save action to prevent data loss.

## 5. Glossary
- **Character Sheet:** A digital record of a player's character in the game.
- **Vehicle Sheet:** A digital record of a vehicle's stats and information.
- **FFG/Edge System:** The Star Wars Roleplaying game system that uses custom dice with symbols.
- **Dice Symbols:** Success, Failure, Advantage, Threat, Triumph, Despair, Force Pip.
