Client-side mod to allow building as if you had a "Builder's Wand" from [insert mod here]

Requires [Architectury API](https://modrinth.com/mod/architectury-api)

***

Rewrite of "Client Builders Wand" by waechter_von_atlantis (licensed under the MIT License)

https://www.curseforge.com/minecraft/mc-mods/client-builders-wand

***

TODO:
- Bugs
  - Wand toggle keybind toggles wand the *entire time* the keybind is pressed; not when key is first pressed or released - leading to the wand toggling more than once in a single press
    - (TBD) Fix: Trigger only once, on key *press* specifically
  - Wand block placement gets stuck in a loop when blocks can't be placed for whatever reason (out of range, impossible block placement position, etc.), leading to the wand being unusable until the player leaves / re-joins the world - which crashes the game, since you can't interact with blocks once the world thread is closed :(
    - (TBD) Workaround: Force-stop block placement loop once a timer (# ticks) has exceeded?
    - (TBD) Fix: idk i'm too tired for this lol

- Updates
    - Port to Quilt (via Architectury)

- Features
    - Max. number of blocks to place per right-click
    - Only place blocks on connected blocks (no building on blocks not (indirectly) attached to the initial block)
    - Restrict placement to specific axis (horizontal, vertical, either, etc.)
