<?php
include 'config.php';

if (isset($_GET['id'])) {
    $nguoiDungID = $_GET['id'];
    $result = $conn->query("SELECT * FROM NguoiDung WHERE NguoiDungID = $nguoiDungID");
    $user = $result->fetch_assoc();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nguoiDungID = $_POST['nguoiDungID'];
    $tenDangNhap = $_POST['tenDangNhap'];
    $hoTen = $_POST['hoTen'];
    $email = $_POST['email'];
    $soDienThoai = $_POST['soDienThoai'];
    $diaChi = $_POST['diaChi'];
    $loaiNguoiDung = $_POST['loaiNguoiDung'];

    $sql = "UPDATE NguoiDung SET TenDangNhap='$tenDangNhap', HoTen='$hoTen', Email='$email', 
            SoDienThoai='$soDienThoai', DiaChi='$diaChi', LoaiNguoiDung='$loaiNguoiDung' 
            WHERE NguoiDungID=$nguoiDungID";

    if ($conn->query($sql) === TRUE) {
        echo "<div class='alert alert-success mt-3'>Cập nhật người dùng thành công!</div>";
    } else {
        echo "<div class='alert alert-danger mt-3'>Cập nhật người dùng thất bại: " . $conn->error . "</div>";
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Người Dùng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Người Dùng</h2>
    <form action="" method="POST">
        <input type="hidden" name="nguoiDungID" value="<?php echo $user['NguoiDungID']; ?>">
        <div class="form-group">
            <label for="tenDangNhap">Tên Đăng Nhập:</label>
            <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" value="<?php echo $user['TenDangNhap']; ?>" required>
        </div>
        <div class="form-group">
            <label for="hoTen">Họ Tên:</label>
            <input type="text" class="form-control" id="hoTen" name="hoTen" value="<?php echo $user['HoTen']; ?>" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<?php echo $user['Email']; ?>" required>
        </div>
        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại:</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" value="<?php echo $user['SoDienThoai']; ?>">
        </div>
        <div class="form-group">
            <label for="diaChi">Địa Chỉ:</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" value="<?php echo $user['DiaChi']; ?>">
        </div>
        <div class="form-group">
            <label for="loaiNguoiDung">Loại Người Dùng:</label>
            <select class="form-control" id="loaiNguoiDung" name="loaiNguoiDung">
                <option value="Khách hàng" <?php echo $user['LoaiNguoiDung'] == 'Khách hàng' ? 'selected' : ''; ?>>Khách hàng</option>
                <option value="Quản trị viên" <?php echo $user['LoaiNguoiDung'] == 'Quản trị viên' ? 'selected' : ''; ?>>Quản trị viên</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
        <a href="admin_dashboard.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
