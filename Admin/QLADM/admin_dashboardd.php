<?php
session_start();

// Kiểm tra xem người dùng đã đăng nhập chưa
if (!isset($_SESSION['username'])) {
    header("Location: login.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bảng Điều Khiển Quản Trị</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
        }

        .container {
            max-width: 800px;
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
            font-size: 2.5em;
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);
        }

        p {
            font-size: 1.2em;
            margin-bottom: 30px;
            color: #333;
        }

        nav {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-bottom: 30px;
        }

        nav a {
            display: block;
            padding: 15px;
            color: white;
            background-color: #007bff;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
        }

        nav a:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            color: white;
            background-color: #dc3545;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 1.2em;
            transition: background-color 0.3s, transform 0.3s;
        }

        .btn:hover {
            background-color: #c82333;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Bảng Điều Khiển Quản Trị</h2>
    <p>Chào mừng, <?php echo $_SESSION['username']; ?>!</p>
    <nav>
        <a href="admin_dashboard.php">Quản Lý Người Dùng</a>
        <a href="admin_dashboard_san_pham.php">Quản Lý Sản Phẩm</a>
        <a href="admin_dashboard_gio_hang.php">Quản Lý Giỏ Hàng</a>
        <a href="admin_donhang.php">Quản Lý Đơn Hàng</a>
        <a href="admin_dashboard_chi_tiet_don_hang.php">Quản Lý Chi Tiết Đơn Hàng</a>
        <a href="admin_dashboard_thanh_toan.php">Quản Lý Thanh Toán</a>
        <a href="admin_dashboard_lich_su_diem.php">Quản Lý Lịch Sử Điểm</a>
        <a href="admin_dashboard_danh_gia.php">Quản Lý Đánh Giá</a>
        <a href="chi_tiet_san_pham.php">Quản Lý Bình Luận</a>
    </nav>
    <button class="btn" onclick="location.href='admin_logout.php'">Đăng Xuất</button>
</div>
</body>
</html>
