-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 29 2024 г., 22:11
-- Версия сервера: 8.0.30
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `mkr`
--

-- --------------------------------------------------------

--
-- Структура таблицы `news`
--

CREATE TABLE `news` (
  `id` int NOT NULL,
  `title` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image_url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `news`
--

INSERT INTO `news` (`id`, `title`, `description`, `image_url`) VALUES
(30, 'Нове відкриття у квантовій фізиці', 'Дослідники знайшли новий спосіб маніпулювання квантовими частинками, що може привести до революційних технологій у квантовій обчислювальній науці.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(31, 'Виявлено нову планету у галактиці', 'Астрономи знайшли нову екзопланету, яка знаходиться в обителі, що може мати умови для розвитку життя.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(32, 'Нові методи лікування раку', 'Науковці анонсували нові методи боротьби з раком, які дозволяють знижувати побічні ефекти та підвищувати ефективність лікування.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(33, 'Штучний інтелект прориває нові межі', 'Дослідження в галузі штучного інтелекту допомагають вирішувати складні завдання, що раніше вважалися неможливими для компютерів.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(34, 'Нові відкриття у генетиці', 'Генетики розкривають нові таємниці геному, що допомагають у боротьбі зі смертельними захворюваннями.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(35, 'Перспективи в енергетиці: альтернативні джерела', 'Дослідження у сфері альтернативних джерел енергії відкривають нові можливості для сталого розвитку суспільства.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(36, 'Нові методи лікування депресії', 'Психологи працюють над новими методами лікування депресії, які можуть полегшити страждання мільйонів людей по всьому світу.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(37, 'Роботехніка: майбутнє вже тут', 'Роботехнології швидко розвиваються, створюючи нові можливості в промисловості, медицині та побуті.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(38, 'Нові відкриття у космічних дослідженнях', 'Астронавти здійснили нові відкриття під час космічних експедицій, що розкривають таємниці космосу.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg'),
(39, 'Передові матеріали для майбутнього', 'Науковці працюють над створенням нових матеріалів, які можуть змінити промисловість, транспорт та медицину у майбутньому.', 'https://i.ytimg.com/vi/7LTMlskhJdI/hqdefault.jpg');

-- --------------------------------------------------------

--
-- Структура таблицы `Subscriptions`
--

CREATE TABLE `Subscriptions` (
  `id` int NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Subscriptions`
--

INSERT INTO `Subscriptions` (`id`, `email`) VALUES
(5, 'STAS@gmail.com');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Subscriptions`
--
ALTER TABLE `Subscriptions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `news`
--
ALTER TABLE `news`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT для таблицы `Subscriptions`
--
ALTER TABLE `Subscriptions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
