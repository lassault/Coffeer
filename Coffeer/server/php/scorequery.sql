select users.username, communities.communityName, scores.coffeeScore, scores.beerScore from (
(scores inner join users on scores.userID = users.userID) 
inner join communities on scores.communityID = communities.communityID)
where users.userID = 2;
