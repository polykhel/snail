# snail

A simple snail sandbox simulator. It shows each step the snail takes on the sandbox to create a certain trail figure.

HOW TO USE THE PROGRAM:
Choose among snail trail presets or set your own random trail.

The presets include:
  1. Diamond
  2. Spiral
  3. Flag
  4. Collage
  
  Example: When user selects the Spiral preset...
  
  It shows this output:
  
          *******************************
        Step 0 of 10
        Place initial value 'o' on starting point
        *******************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 |                o             |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O
        
        
        
        **********************************
        	   Step 1 of 10
        Direction: L Steps: 1 Content: o
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 |             o  o             |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O
        
        ...Steps 2 - 8
        
        **********************************
        	   Step 9 of 10
        Direction: L Steps: 9 Content: o
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 | o  o  o  o  o  o  o  o  o  o |
        2 |                            o |
        3 |       o  o  o  o  o  o     o |
        4 |       o              o     o |
        5 |       o     o  o     o     o |
        6 |       o     o        o     o |
        7 |       o     o        o     o |
        8 |       o     o  o  o  o     o |
        9 |       o                    o |
        0 |       o  o  o  o  o  o  o  o |
          O------------------------------O
        
        
        
        **********************************
        	   Step 10 of 10
        Direction: D Steps: 9 Content: o
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 | o  o  o  o  o  o  o  o  o  o |
        2 | o                          o |
        3 | o     o  o  o  o  o  o     o |
        4 | o     o              o     o |
        5 | o     o     o  o     o     o |
        6 | o     o     o        o     o |
        7 | o     o     o        o     o |
        8 | o     o     o  o  o  o     o |
        9 | o     o                    o |
        0 | o     o  o  o  o  o  o  o  o |
          O------------------------------O

  
If you want to create your own trail, here are the instructions:
O---------------------------------------O
| NOTE: A command consists of <D><S><C> |
|                                       |
| where,                                |
|   <D> - direction ('U' up, 'D' down,  |
|         'R' right, 'L' left)          |
|   <S> - steps (integers '1-9')        |
|   <C> - content (characters)          |
| EXAMPLE: U5* (5 steps up, place *)    |
|                                       |
| type \"END\" to stop inputting commands |
O---------------------------------------O

Example:
        Enter Start Point Row (1-10 only): 5
        Enter Start Point Column (1-10 only): 1
        Enter Start Point Content: H
        
        Enter command 1: r1e
        Current row: 5 Current column: 2
        Enter command 2: r2l
        Current row: 5 Current column: 4
        Enter command 3: r1o
        Current row: 5 Current column: 5
        Enter command 4: end
        *******************************
        Step 0 of 3
        Place initial value 'H' on starting point
        *******************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 | H                            |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O
        
        
        
        **********************************
        	   Step 1 of 3
        Direction: R Steps: 1 Content: e
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 | H  e                         |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O
        
        
        
        **********************************
        	   Step 2 of 3
        Direction: R Steps: 2 Content: l
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 | H  e  l  l                   |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O
        
        
        
        **********************************
        	   Step 3 of 3
        Direction: R Steps: 1 Content: o
        **********************************
            1  2  3  4  5  6  7  8  9  0
          O------------------------------O
        1 |                              |
        2 |                              |
        3 |                              |
        4 |                              |
        5 | H  e  l  l  o                |
        6 |                              |
        7 |                              |
        8 |                              |
        9 |                              |
        0 |                              |
          O------------------------------O


Thank you. :)
