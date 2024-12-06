<?php
include 'config.php';

if (isset($_GET['id'])) {
    $nguoiDungID = $_GET['id'];
    $sql = "DELETE FROM NguoiDung WHERE NguoiDungID = $nguoiDungID";

    if ($conn->query($sql) === TRUE) {
        echo "<div class='alert alert-success mt-3'>Xóa người dùng thành công!</div>";
    } else {
        echo "<div class='alert alert-danger mt-3'>Xóa người dùng thất bại: " . $conn->error . "</div>";
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xóa Người Dùng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Xóa Người Dùng</h2>
    <a href="admin_dashboard.php" class="btn btn-secondary">Quay lại</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
