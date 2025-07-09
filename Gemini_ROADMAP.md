# Project Roadmap: SWRPG Sheet Manager

This document outlines the planned development phases for the SWRPG Sheet Manager.

## Milestone 1: Project Setup & Core Data Models (Foundation)
- [x] Create Software Requirements Specification (SRS).
- [x] Define application architecture (MVVM).
- [x] Define project roadmap.
- [ ] Initialize Compose Multiplatform project with the standard structure.
- [ ] Set up SQLDelight for data persistence.
- [ ] Define the core SQL schema and data classes for:
    - `Character` (Characteristics, Skills, basic info)
    - `Vehicle` (Base stats)
- [ ] Create a simple "Character List" screen that can add and display placeholder characters from the database.

## Milestone 2: Character Sheet Implementation (Core Feature)
- [ ] Design and implement the full UI for the Character Sheet screen.
- [ ] Allow viewing and editing of all character fields (Wounds, Strain, etc.).
- [ ] Implement logic for automatically calculating derived stats (e.g., Soak).
- [ ] Connect the UI to the `CharacterSheetViewModel`.
- [ ] Ensure all character data is correctly saved to and loaded from the database.
- [ ] Implement inventory and credits management.

## Milestone 3: The Dice Roller (Key Utility)
- [ ] Create the UI for the Dice Roller screen.
- [ ] Implement the dice pool selection controls.
- [ ] Write the business logic for rolling and calculating the net results of a dice pool.
- [ ] Display the results clearly to the user, including highlighting Triumphs and Despairs.

## Milestone 4: Vehicle Sheet Implementation
- [ ] Design and implement the UI for the Vehicle Sheet screen.
- [ ] Allow creating, viewing, editing, and deleting vehicles.
- [ ] Implement Hull Trauma, System Strain, and Armor tracking.
- [ ] Ensure all vehicle data is correctly persisted.

## Milestone 5: Polish & Packaging
- [ ] Refine the UI/UX with a thematic Star Wars look and feel.
- [ ] Add subtle animations and improve responsiveness.
- [ ] Conduct testing on all target platforms (Android, Windows, Linux).
- [ ] Fix bugs and address performance issues.
- [ ] Set up build configurations to produce release packages:
    - Android: Signed `.apk` or `.aab`.
    - Desktop: `.exe`/`.msi` for Windows, `.deb`/`.AppImage` for Linux.

## Future Goals (Post-V1.0)
- [ ] Import/Export functionality for sheets.
- [ ] Cloud sync (optional, requires backend).
- [ ] Pre-populated database of species, careers, talents, and equipment.
- [ ] GM screen for managing multiple characters/NPCs at once.
