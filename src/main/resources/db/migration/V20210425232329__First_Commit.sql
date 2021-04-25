create table match_model
(
    id              varchar(255) not null,
    email           varchar(255),
    game_name       varchar(255),
    player_one_name varchar(255),
    player_two_name varchar(255),
    score_left      int4         not null,
    score_right     int4         not null,
    primary key (id)
);