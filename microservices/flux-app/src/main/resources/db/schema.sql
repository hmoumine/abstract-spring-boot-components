CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";
DROP TABLE IF EXISTS Pole;
CREATE TABLE Pole
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(255) not null
);


