INSERT INTO author (id, name)
VALUES (1, '디온');
INSERT INTO author (id, name)
VALUES (2, '푸글');

INSERT INTO post (id, title, text, category, author_id)
VALUES (1, '디온 최고', '써니 좋아', null, 1);
INSERT INTO post (id, title, text, category, author_id)
VALUES (2, '다이앤', '푸글구글', '인텔리제이', 2);