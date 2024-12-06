<?php
include 'DanhGia.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$danhGia = new DanhGia($conn);

if (isset($_GET['id'])) {
    $danhGiaItem = $danhGia->layTheoId($_GET['id']);
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['id'];
    $noiDung = $_POST['noiDung'];
    $diem = $_POST['diem'];

    if ($danhGia->sua($id, $noiDung, $diem)) {
        header("Location: admin_dashboard_danh_gia.php");
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Đánh Giá</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Đánh Giá</h2>
    <form method="POST">
        <input type="hidden" name="id" value="<?php echo $danhGiaItem['DanhGiaID']; ?>">
        <div class="form-group">
            <label for="noiDung">Nội Dung:</label>
            <textarea class="form-control" id="noiDung" name="noiDung" required><?php echo $danhGiaItem['NoiDung']; ?></textarea>
        </div>
        <div class="form-group">
            <label for="diem">Điểm:</label>
            <input type="number" class="form-control" id="diem" name="diem" value="<?php echo $danhGiaItem['Diem']; ?>" min="1" max="5" required>
        </div>
        <button type="submit" class="btn btn-warning">Cập Nhật</button>
        <a href="admin_dashboard_danh_gia.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.2.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
