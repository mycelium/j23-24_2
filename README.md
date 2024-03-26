## Java lessons | Spring 2023

### Tasks

1. [Weather Bot](https://github.com/mycelium/j23#weather-bot)
2. [Quiz Bot](https://github.com/mycelium/j23#quiz-bot)
3. [Task Management Bot](https://github.com/mycelium/j23#task-management-bot)
4. [Movie Recommendation Bot](https://github.com/mycelium/j23#movie-recommendation-bot)
5. [Currency Converter Bot](https://github.com/mycelium/j23#currency-converter-bot)
6. [Event Reminder Bot](https://github.com/mycelium/j23#event-reminder-bot)
7. [Restaurant Finder Bot](https://github.com/mycelium/j23#restaurant-finder-bot)
8. [Trip Planner Bot](https://github.com/mycelium/j23#trip-planner-bot)


### Common requiremens (for all variants):

1. Sources and artifacts
- Code should be somewhere in GitHub (your own)
  - README with guide!!!
- Target artifact for app - runnable fat jar
- Target build object for deploy - docker container
- Build tool should be used (Maven or Gradle)
2. Tech stack
- Telegram API
- Java 21 / Kotlin / Scala 3
- Spring 5 / Spring 6
- **Spring Boot is prohibited for all students**
- Docker, Docker compose, Docker Hub
3. Try to develop "good architecture"
4. How to submit:
- Link to code (github repo) with guide (!!!)
- Link to DockerHub
- Link to TelegramBot
5. Specific requirements (technical restrictions, etc) are in [google sheet](https://docs.google.com/spreadsheets/d/10z1jzQlLLCwt9R-v_YpiCXi6eigLiDBDo3SjdsSOOEA/edit#gid=399413437)

#### Weather Bot

##### Features

1. Sign up
2. Sign in
3. Location
- Set location
  - City
  - Geomarker
- Show location
- Update location
4. Weather
- Show current (now + rest of the day)
- Show forecast (this day, next day, 3 days): morning, noon, evening
- Show for another city
5. Schedule
- Show every <timeunit>

##### Bonus

1. Alarm user about coming:
- Precepitation
- Cataclysm
- etc
2. Accept a Live User Location and use it for weather and alarms

##### Note

- You can use any open API like OpenWeatherMap

#### Quiz Bot

##### Features

1. Sign up
2. Sign in
3. Questions & Answers
- Add question with answer and tags
4. Quiz
- Automatically send one random question every morning
- Ask for a random question
- Ask for a random question from desired theme (by tags)
5. Score
- Show score
- Reset score (drop to zero)
- Show score by themes (tags)

##### Bonus

1. Groups
- Create groups
- Invite members
- Group score table
- Group question every morning (random question from all group users) 
2. Neighbors
- Question from/to neighbors (by location)
- Share score with neighbors (show distance)


#### Task Management Bot

##### Features

1. Sign up
2. Sign in
3. Task
- Create task (summary, estimation, deadline)
- Update task (add spent time, mark as done, change deadline)
- Show tasks by deadline (today, tomorrow, week)
4. Recurring tasks
- Create reccuring tasks (hourly, daily, weekly, monthly)
- Show recurring tasks
- Update recurring tasks
- Delete recurring tasks
5. Reminder
- Remind about deadlines
- Remind about not updated tasks

##### Bonus

1. Integration with issue tracker (Youtrack, ClickUp, Jira, Trello...)
2. Integration with Calendar 

#### Movie Recommendation Bot

##### Features

1. Sign up
2. Sign in
3. Preferences
- Show user preferences
- Add preferences (e.g., genre, actors, release year)
- Delete preferences
4. Find a film
- Request a film with query (genre, actors, release year, keywords ...)
  - If some criterias are not set - user preferences should be used
  - Allow setting `skip` for criteria to skip it
- Request a random film
5. Watch list
- Add film to watchlist
- Show watchlist
- Mark film as watched
- Remove film from watchlist

##### Bonus

1. Marks
- Add marks to watched films (-10..0..10)
- Find similar films
- Show all watched films for period
2. Sharing
- Share watch list with other user
- Share watched films for period with other user

#### Currency Converter Bot

##### Features

1. Sign up
2. Sign in
3. Preferences
- Home currency (RUB for example)
- Default pair (RUB-USD for example)
4. Converter
- Request Exchange rate
  - If nothing set - default pair used
  - If one currency specified - compare with Home currency
  - IF two currencies specified - show their exchange rate
- Convert specified amount
  - The same rules but with specified amount
5. History
- Show all requests for a specified period
- Show requests for a specified currency/pair for a period

##### Bonus

1. Alarms
- Set an alarm for desired exchange rate
- Show alarms
- Delete alarms
2. Calculator
- Add math operators (`+`, `-`,`*`, `/`) and brackets ( (24+17)*3 + 155.15 - 25 USD->RUB )
- Allow calculations with different currencies ( 24USD + 15.5EUR + 17RUB)
  - If currency not specified - used Home currency


#### Event Reminder Bot

##### Features

1. Sign up
2. Sign in
3. Event
- Create event (summary, date + time, duration)
- List events (next <number of events>, day, week)
- Import event as `.ics` file
- Delete event
- Update event
4. Recurring events
- Create reccuring events (hourly, daily, weekly, monthly)
- Show recurring tasks
- Update recurring tasks
- Delete recurring tasks
5. Reminder
- Remind about upcoming event
  
##### Bonus

1. Integration with calendar (google, yandex, teamup, etc)
- Add calender integration
- Add events to calenders from bot
- Remind about upcoming events from calendars
2. Collaborative events
- Add collaborators to event
- Nearest events (geolocation)
   
#### Restaurant Finder Bot

##### Features

1. Sign up
2. Sign in
3. Preferences
- Show user preferences
- Add preferences (e.g. vegetarian, allergies, intalian, fish, etc)
- Delete preferences
4. Find a restaruant
- Request a film with query (location, kitchen, keywords, etc)
  - If some criterias are not set - user preferences should be used
  - Allow setting `skip` for criteria to skip it
- Request a random restaurant (location + area)
5. Visit list
- Add restaurant to visit list
- Show list
- Mark restaurant as visited
- Remove restaurant from list

##### Bonus

1. Marks
- Add marks to restaurants (-10..0..10)
- Find similar restaurant
- Add marks to dishes
2. Routes
- Create route for visting several restaurant to eat different dishes
- Save and share routes

#### Trip planner Bot

##### Features

1. Sign up
2. Sign in
3. Planned trips
- Show all planned trips
- Plan a trip (create trip and set points and routes (flights/trains/buses) with dates)
- Delete planned trip
4. Trip helper
- Remind about closest trips
- When trip starts:
  - send location to mark point as visited
  - Mark point manually
  - add notes to point
5. Trips history
- List all finished trips
- Show details for specific finished trip
- Add score for finished trip

##### Bonus

1. Photos
- Add photos to point
- Show photos for fihished trip
- Make a collage from photos by points
2. Trip recommendation
- Suggest a trip for user
  - by combination of visited points
  - using ChatGPT with new points
