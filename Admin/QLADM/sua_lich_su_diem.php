<?php
include 'LichSuDiem.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$lichSuDiem = new LichSuDiem($conn);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['id'];
    $diemThang = $_POST['diemThang'];

    if ($lichSuDiem->sua($id, $diemThang)) {
        header("Location: admin_dashboard_lich_su_diem.php");
        exit();
    }
}

$lichSu = $lichSuDiem->layTheoId($_GET['id']);
?>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Lịch Sử Điểm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Sửa Lịch Sử Điểm</h2>
    <form method="POST">
        <input type="hidden" name="id" value="<?php echo $lichSu['LichSuDiemID']; ?>">
        <div class="form-group">
            <label for="diemThang">Điểm Tháng:</label>
            <input type="number" class="form-control" id="diemThang" name="diemThang" value="<?php echo $lichSu['DiemThang']; ?>" required>
        </div>
        <button type="submit" class="btn btn-warning">Cập nhật</button>
        <a href="admin_dashboard_lich_su_diem.php" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
