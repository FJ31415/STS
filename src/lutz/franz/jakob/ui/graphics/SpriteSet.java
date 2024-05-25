package lutz.franz.jakob.ui.graphics;

import lutz.franz.jakob.ui.graphics.gui.GUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SpriteSet {
    private final BufferedImage[] sprites;

    public SpriteSet(String filePath, int nrOfSprites) {
        sprites = new BufferedImage[nrOfSprites];
        loadSprites(loadAtlas(filePath));
    }

    private BufferedImage loadAtlas(String filePath) {
        BufferedImage atlas = null;

        // System.out.println(new File(filePath).getAbsolutePath());
        try (InputStream is = new FileInputStream(new File(filePath))) {
            atlas = rescale((BufferedImage) ImageIO.read(is));
        } catch (IOException e) {
            System.out.println("Failed to load atlas!\n" + e.getLocalizedMessage());
        }

        return atlas;
    }

    private BufferedImage rescale(BufferedImage img) {
        BufferedImage rImg = new BufferedImage(img.getWidth() * GUI.RESCALE_FACTOR, img.getHeight() * GUI.RESCALE_FACTOR, 2);

        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++)
                for (int sx = 0; sx < GUI.RESCALE_FACTOR; sx++)
                    for (int sy = 0; sy < GUI.RESCALE_FACTOR; sy++)
                        rImg.setRGB((x * GUI.RESCALE_FACTOR) + sx, (y * GUI.RESCALE_FACTOR) + sy, img.getRGB(x, y));

        return rImg;
    }

    private void loadSprites(BufferedImage atlas) {
        int x = 0, y = 0;
        for (int i = 0; i < sprites.length; i++) {
            if (x > atlas.getWidth()) {
                x = 0;
                y += Sprite.SIZE;
                // end of file
                if (y + Sprite.SIZE > atlas.hashCode())
                    return;
            }

            sprites[i] = atlas.getSubimage(x, y, Sprite.SIZE, Sprite.SIZE);

            x += Sprite.SIZE;
        }
    }

    // getter

    public BufferedImage getSprite(int idx) {
        return sprites[idx];
    }

    public BufferedImage getSprite(Sprite s) {
        return sprites[s.ordinal()];
    }
}