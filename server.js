// const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
app.use(express.json({ limit: '50mb' })); // Increase request size limit for Base64

// Route to handle image upload
app.post('/ImgVidCapture/add', async (req, res) => {
  try {
    // Get Base64 image data from request body
    const { image } = req.body;

    // Decode Base64 data and save it as a file
    const buffer = Buffer.from(image, 'base64');
    const filePath = path.join(__dirname, 'uploads', `captured-image-${Date.now()}.jpg`);

    // Save the file
    fs.writeFile(filePath, buffer, (err) => {
      if (err) {
        console.error('Error saving image:', err);
        return res.status(500).json({ error: 'Failed to save image' });
      }

      // Respond with the image URL (assuming it's accessible via localhost/uploads/)
      const imageUrl = `http://localhost:8080/uploads/${path.basename(filePath)}`;
      res.json({ imageUrl, message: 'Image uploaded successfully' });
    });
  } catch (error) {
    console.error('Error handling upload:', error);
    res.status(500).json({ error: 'Internal server error' });
  }
});

// Serve uploaded images statically from the "uploads" folder
app.use('/uploads', express.static(path.join(__dirname, 'uploads')));

const PORT = 8080;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
