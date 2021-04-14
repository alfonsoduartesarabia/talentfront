INSERT INTO `user_experience` (`user_exeperince_id`, `job_title`, `company`, `description`, `date_start`, `date_end`, `user_id`)
VALUES
(1, 'Software Engineer', 'Boeing', 'Working with users to determine their software needs\nDesigning, developing and testing a system or application according to the users’ specifications\nDrawing diagrams and models that help developers create the appropriate code for the system or application\nDocumenting the system or application in detail to help those responsible for future maintenance\nMaintaining the system or application with updates and fixes as necessary\nRecommending software upgrades for existing systems or applications\nCollaborating with developers and other engineers to create software', '2017-01-10', '2019-07-14', 1),
(2, 'Software Engineer Lead', 'SpaceX', 'I was responsible for their team’s execution, the quality they produce, the speed and cadence at which they produce, but most importantly, I was responsible for the team’s culture, environment, and overall growth of the people on it', '2019-07-14', NULL, 1);

INSERT INTO `user_session` (`user_session_id`, `user_id`, `verification`, `created_dt`)
VALUES
(1, 1, '4019a1e4-a008-444f-803b-f8204421ffe6', '2021-04-12 07:14:11'),
(2, 1, 'ae7e818a-497d-4366-a557-8c4c85578e04', '2021-04-12 07:17:25');

INSERT INTO `user_skill` (`user_skill_id`, `user_id`, `skill`)
VALUES
(1, 1, 'Java'),
(2, 1, 'Sql'),
(3, 1, 'Docker'),
(4, 1, 'Kubernetes'),
(5, 1, 'Object Oriented Programming'),
(6, 2, 'Typescript'),
(7, 2, 'React'),
(8, 2, 'Json'),
(9, 2, 'Swift');

INSERT INTO `user_company` (`user_company_id`, `user_id`, `company_name`)
VALUES
(1, 1, 'Boeing'),
(2, 1, 'SpaceX');
