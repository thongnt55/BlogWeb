
ALTER TABLE post
  ALTER COLUMN create_date SET DEFAULT CURRENT_TIMESTAMP;

-- Users
-- password in plaintext: "password"
INSERT INTO user (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com', 'user', 'Name', 'Surname',
   1);
-- password in plaintext: "password"
INSERT INTO user (user_id, password, email, username, name, last_name, active)
VALUES
  (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'johndoe@gmail.com', 'johndoe', 'John', 'Doe', 1);
-- password in plaintext: "password"
INSERT INTO user (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'ana@mail.com', 'ana', 'Ana', 'Surname', 1);

-- Roles
INSERT INTO role (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

-- User Roles
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (1, 2);
INSERT INTO user_role (user_id, role_id)
VALUES (2, 2);
INSERT INTO user_role (user_id, role_id)
VALUES (3, 2);
--Category
INSERT INTO CATEGORY ( CATEGORY_ID , CATEGORY_NAME ) VALUES (1, 'Tech');
INSERT INTO CATEGORY ( CATEGORY_ID , CATEGORY_NAME ) VALUES (2, 'Medical');
INSERT INTO CATEGORY ( CATEGORY_ID , CATEGORY_NAME ) VALUES (3, 'Social');
INSERT INTO CATEGORY ( CATEGORY_ID , CATEGORY_NAME ) VALUES (4, 'Games');
INSERT INTO CATEGORY ( CATEGORY_ID , CATEGORY_NAME ) VALUES (5, 'Economy');

--Tag
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (1, '#ss');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (2, '#aa');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (3, '#cc');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (4, '#vv');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (5, '#xx');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (6, '#ssz');
INSERT INTO TAG ( TAG_ID , TAG_NAME ) VALUES (7, '#uu');
-- Posts
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (1, 1, 'Bài viết 1',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        --         CURRENT_TIMESTAMP());
        {ts '2016-10-19 11:10:13.247'}, 'Bài viết 1');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (2, 1, 'Bài viết 2',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        --         CURRENT_TIMESTAMP());
        {ts '2016-11-10 11:10:13.247'}, 'Bài viết 2');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (3, 1, 'Bài viết 3',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 3');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (4, 1, 'Bài viết 4',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 4');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (5, 1, 'Bài viết 5',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 5');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (6, 1, 'Bài viết 6',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 6');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (7, 2, 'Bài viết 7',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 7');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (8, 2, 'Bài viết 8',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 8');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (9, 2, 'Bài viết 9',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 9');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (10, 2, 'Bài viết 10',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 10');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (11, 3, 'Bài viết 11',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 11');
INSERT INTO post (post_id, user_id, title, body, create_date, description)
VALUES (12, 3, 'Bài viết 12',
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP(), 'Bài viết 12');

-- Comments
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (1, 1,
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP());
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (1, 2,
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP());
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (1, 3,
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP());
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (6, 1,
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP());
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (6, 2,
        'Trao đổi với Tuổi Trẻ, luật sư Trương Anh Tú (Đoàn luật sư TP Hà Nội) bày tỏ: "Dàn dựng nội dung thông tin không có thật, mạo nhận các đài truyền hình để lấy niềm tin người bệnh đã làm xấu hình ảnh, hạ uy tín các cơ quan báo chí. Nguy hiểm hơn, đây lại là thủ đoạn gian dối để bán thuốc dỏm trục lợi".',
        CURRENT_TIMESTAMP());
INSERT INTO comment (post_id, user_id, body, create_date)
VALUES (6, 3,
        '"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."',
        CURRENT_TIMESTAMP());