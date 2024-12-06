<?php
include 'NguoiDung.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$nguoiDung = new NguoiDung($conn);
$users = $nguoiDung->layTatCa();
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Người Dùng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
<a href="admin_dashboardd.php" class="btn btn-primary" >Quay lại</a>

    <h2>Quản Lý Người Dùng</h2>
    <a href="them_nguoi_dung.php" class="btn btn-primary mb-3">Thêm Người Dùng</a>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Họ Tên</th>
                <th>Email</th>
                <th>Số Điện Thoại</th>
                <th>Địa Chỉ</th>
                <th>Loại Người Dùng</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($users as $user): ?>
            <tr>
                <td><?php echo $user['NguoiDungID']; ?></td>
                <td><?php echo $user['HoTen']; ?></td>
                <td><?php echo $user['Email']; ?></td>
                <td><?php echo $user['SoDienThoai']; ?></td>
                <td><?php echo $user['DiaChi']; ?></td>
                <td><?php echo $user['LoaiNguoiDung']; ?></td>
                <td>
                    <a href="sua_nguoi_dung.php?id=<?php echo $user['NguoiDungID']; ?>" class="btn btn-warning">Sửa</a>
                    <a href="xoa_nguoi_dung.php?id=<?php echo $user['NguoiDungID']; ?>" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
