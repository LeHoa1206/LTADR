<?php
include 'config.php';
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Người Dùng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Thêm Người Dùng</h2>
    <form action="" method="POST">
        <div class="form-group">
            <label for="tenDangNhap">Tên Đăng Nhập:</label>
            <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required>
        </div>
        <div class="form-group">
            <label for="matKhau">Mật Khẩu:</label>
            <input type="password" class="form-control" id="matKhau" name="matKhau" required>
        </div>
        <div class="form-group">
            <label for="hoTen">Họ Tên:</label>
            <input type="text" class="form-control" id="hoTen" name="hoTen" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại:</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai">
        </div>
        <div class="form-group">
            <label for="diaChi">Địa Chỉ:</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi">
        </div>
        <div class="form-group">
            <label for="loaiNguoiDung">Loại Người Dùng:</label>
            <select class="form-control" id="loaiNguoiDung" name="loaiNguoiDung">
                <option value="Khách hàng">Khách hàng</option>
                <option value="Quản trị viên">Quản trị viên</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="admin_dashboard.php" class="btn btn-secondary">Quay lại</a>
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $tenDangNhap = $_POST['tenDangNhap'];
        $matKhau = password_hash($_POST['matKhau'], PASSWORD_DEFAULT);
        $hoTen = $_POST['hoTen'];
        $email = $_POST['email'];
        $soDienThoai = $_POST['soDienThoai'];
        $diaChi = $_POST['diaChi'];
        $loaiNguoiDung = $_POST['loaiNguoiDung'];

        $sql = "INSERT INTO NguoiDung (TenDangNhap, MatKhau, HoTen, Email, SoDienThoai, DiaChi, LoaiNguoiDung)
                VALUES ('$tenDangNhap', '$matKhau', '$hoTen', '$email', '$soDienThoai', '$diaChi', '$loaiNguoiDung')";

        if ($conn->query($sql) === TRUE) {
            echo "<div class='alert alert-success mt-3'>Thêm người dùng thành công!</div>";
        } else {
            echo "<div class='alert alert-danger mt-3'>Thêm người dùng thất bại: " . $conn->error . "</div>";
        }
    }
    ?>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
