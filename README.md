# WorldRepair
## What is WordRepair?
WordRepair is a Minecraft world analyzation tool to figure out if there are any corrupted chunks.<br>
The motivation behind this project is to locate broken parts in the NBT files of a mc world since <br>
one of our world is so fucked up that WorldEdit, regionFixer and all those programms crashed while loading the world.
## What kind of black magic is this application doing ?
Currently, it is a pure **alpha** version and can only detect corrupted region files / chunks and prints them to the console.<br>
## What features are planed ?<br>
To be honest, not that much but a way to fix broken parts (delete them / mark them for regeneration) would be neet
## How is working?
Since all NBT APIs are literally shit I implemented the offical api implementation of Minecraft.<br>
This has the good side-effect that all issues that ocurre in the game will also ocurre in this app.<br>
But if this app also crashes, why the f*ck should I use it? you might ask, well that pretty easy, I also implemeted<br>
a pipeline API where you can add custom 'healthchecks' on diffrent levels of the nbt structure. Therefore you could iron out<br>
and debug your world crashes and make this app generally more prepared against various world issues.
