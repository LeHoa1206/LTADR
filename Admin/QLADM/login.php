<?php
session_start();

// Kiểm tra xem đã gửi thông tin từ biểu mẫu chưa
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Kiểm tra thông tin đăng nhập (ví dụ: tài khoản và mật khẩu cứng)
    if ($username == 'admin' && $password == '1243') {
        $_SESSION['username'] = $username;
        header("Location: admin_dashboardd.php");
        exit;
    } else {
        echo "<script>alert('Tên tài khoản hoặc mật khẩu không chính xác!');</script>";
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập Quản Trị</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
        }

        .container {
            max-width: 400px;
            margin: auto;
            padding: 40px;
            background: white;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            margin-top: 100px;
        }

        h2 {
            color: #007bff;
            margin-bottom: 20px;
            font-size: 2em;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 1.2em;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
        }

        .btn:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Đăng Nhập Quản Trị</h2>
    <form action="login.php" method="post">
        <div class="form-group">
            <label for="username">Tên Tài Khoản:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Mật Khẩu:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="btn">Đăng Nhập</button>
    </form>
</div>
</body>
</html>
