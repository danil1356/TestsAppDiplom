CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    status VARCHAR (255) NOT NULL
);

CREATE TABLE roles
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE user_role
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
);

CREATE TABLE themes
(
    id             		 SERIAL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL
);

CREATE TABLE subthemes
(
    id         			 SERIAL PRIMARY KEY,
    theme_id             INTEGER REFERENCES themes (id),
    name                 VARCHAR(255) NOT NULL
);

CREATE TABLE question_type
(
    id     				 SERIAL PRIMARY KEY,
    type                 VARCHAR(255) NOT NULL
);

CREATE TABLE tests
(
    id             		 SERIAL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL,
    execution_time       TIME NOT NULL,
    user_id              INTEGER REFERENCES users (id),
    author               VARCHAR(255) NOT NULL,
    theme_id             INTEGER REFERENCES themes (id),
    subthemes_id         INTEGER REFERENCES subthemes (id)
);

CREATE TABLE statistics
(
    id        			 SERIAL PRIMARY KEY,
    user_id              INTEGER REFERENCES users (id),
    tests_id             INTEGER REFERENCES tests (id),
    test_result          INTEGER NOT NULL
);

CREATE TABLE questions
(
    id         			 SERIAL PRIMARY KEY,
    question             VARCHAR(255) NOT NULL,
    tests_id             INTEGER REFERENCES tests (id),
    question_type_id     INTEGER REFERENCES question_type (id)
);


CREATE TABLE Answer
(
    id            		 SERIAL PRIMARY KEY,
    is_correct           boolean NOT NULL,
    questions_id         INTEGER REFERENCES questions (id),
    answer               VARCHAR(255) NOT NULL
);

CREATE TABLE image_data
(
    id             		 SERIAL PRIMARY KEY,
    img_src              VARCHAR(255) NOT NULL,
    questions_id         INTEGER REFERENCES questions (id)
);



