Project Description and Motivation:

Greg and I are planning on making a website for creating pokémon and hosting them alongside pokedexes to store them in. This means that a user can create pokémon and keep track of them using their own public/private pokedex. Users will also be able to collaborate on their pokédexes through invitations sent by the creator. The reason we decided to take on this project was to build upon our first unit project regarding a pokémon database, and to add more user focused content for convient hosting of custom pokémon. Not only will this allow us to show our growth from our beginning, but this will also allow us to work on more user generated content and it's proper maintenance.

Prior Art: References ([Official Pokémon Pokédex](https://www.pokemon.com/us/pokedex/), [Similar "create a pokémon Website"](https://www.smogon.com/cap/pokemon/))

Our prior art is based off the offical pokémon pokédex which is used in pretty much anything Pokémon. Much like the site linked we'll have a page for viewing the pokémon and possibly the pokédex thier apart of. For the second link, Smogon, we have a similar concept by being able to create pokémon on the site, but our site will allow for more general creation than the linked one. The Smogon webiste Was made and used by professional teams instead of the public, but our will be more focused on a public use case.

Core User Workflow: 

Landing Page(Bass)

  - Navbar at the top with the title, signup, and log in.

  - The title will lead to home from any page it's on.

  - signup and login will be replaced with username and logout while logged in.

  - logout will send the user back home and place signup and login back.

Databases(Greg)

  - A Pokémon information table(ID, Name, "Pokédex or entry number", Pokémon entry(short description), Height, Weight, Gender, Category(Breeding),  Abilities, Types, Weaknesses, and Evolutions)

  - A Pokédex table(ID, Dex Name, Creator, Pokémon ID(Gotten from Pokémon table), Collaborators)

  - A Users table(Username, Password, Collaborating)

Sign up Log in (Bass)

  - signup and login will both lead back to the home page after completion.
Signup will automatically login the user so they do not need to login

Create(Greg)

  - Pokemon create Page that allows the user to input

  - After Clicking "Create" the user will be taken to the Pokémons Detail Page

      - Name

      - Entry

      - Type(From API)

      - Height

      - Weight

      - Gender

      - Category(From API)

      - Abilities

      - weaknesses

      - evolutions

      - Public / Private

Pokédex Create page

  - After creating the Dex the user will be taken to the Dex page where they can add Pokémon to the Dex and add Collaborators

  - Users can select the name of Pokémon if the Pokémon is already created
  otherwise, the user creates Pokémon directly in the Pokédex.

  - The user is redirected to the "Create" page and when they click the create button it automatically puts the Pokémon into the Déx

  - Add Collaborators via typing Username

Views

PokéDex(Greg)

 - Users can view All Pokemon in the Déx

 - View Collaborators

 - View Creator

 - Both the Collaborators and Creator names would be clickable and redirect to the Users page

All Pokémon(Bass)

  - Upvote System 
  - A clickable button that adds the upvote amount by 1

Top Pokémon(Greg)

  - Top Upvoted from most to least while only showing the top 100 Pokémon at a time

Pokemon detail page(Greg)

User Page(Bass)

  - Shows Username
  - Dex's worked on public
  - created public Pokémon
  - If the person viewing is said user they can see all private as well

Project Timeline: 

  - Week 1:
  
    - Landing page
    
    - Database setup and tables
    
  - Week 2:
  
    - Sign up/login

    - All create views

    - First API set up

  - Week 3:

     - Dex Views(Greg)

     - Pokémon(Greg)

     - Top Pokémon(Bass)

     - User(Bass)

  - Week 4:

    - Styling

    - Bug Testing

    - Revision

    - Possible Hosting

Technologies:

  - Languages:
    - Java
    - HTML/CSS
    - JS
  
 -  Frameworks:
    - Spring
    - AWS

Repository:

  [Our Github Repository](https://github.com/Sbowles21/Capstone-Greg-Bass)
