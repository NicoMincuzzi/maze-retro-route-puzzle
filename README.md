# A-Maze-ingly Retro Route Puzzle

This code exercise is (very loosely) based on some of the ideas in old school [text adventure](https://en.wikipedia.org/wiki/Interactive_fiction) games.

## Description

Moving on... in this exercise you are supplied with a JSON document that describes an adventure game map. It will look something like this:

``` json
{
   "rooms":[
      {
         "id":1,
         "name":"Hallway",
         "north":2,
         "objects":[]
      },
      {
         "id":2,
         "name":"Dining Room",
         "south":1,
         "west":3,
         "east":4,
         "objects":[]
      },
      {
         "id":3,
         "name":"Kitchen",
         "east":2,
         "objects":[
            {
               "name":"Knife"
            }
         ]
      },
      {
         "id":4,
         "name":"Sun Room",
         "west":2,
         "objects":[
            {
               "name":"Potted Plant"
            }
         ]
      }
   ]
}
```

As you can see, a room may or may not permit travel in one of the four cardinal directions and may or may not contain "objects". 

By command prompt is possible to insert the ID of the room the player starts in, and afterward list the name of an object they must collect. 
This file will look something like this:

```
2
Potted Plant, Knife
```

## Goals

The objective is to write a program that will:
- Parse the JSON and create a model of the map 
- Read the plain text file, noting which room to start in and which items must be collected
- Output a valid route one could take to collect all the items specified in the text file


Given the above example the following is (one of the potentially) correct outputs:

```
ID  Room          Object collected
----------------------------------
1   Hallway       None
2   Dining Room   None
3   Kitchen       Knife
2   Dining Room   None
4   Sun Room      Potted Plant
```

There are going to be questions people have as they seek to clarify the above requirements, e.g. "Does my output have to be exactly like the example? Do I have to find the optimal route or simple a valid route?" I'm unlikely to provide any further clarification, but rather ask people to make and state their assumptions as part of their work.

## Build instructions

## Usage