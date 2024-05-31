package lutz.franz.jakob.presentation.gui;

import lutz.franz.jakob.presentation.graphics.Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SpriteSet {
    private final ArrayList<BufferedImage> sprites;

    public SpriteSet(String filePath, int nrOfSprites) {
        sprites = new ArrayList<>();
        loadSprites(loadAtlas(filePath));
    }

    private BufferedImage loadAtlas(String filePath) {
        BufferedImage atlas = null;

        // System.out.println(new File(filePath).getAbsolutePath());
        try (InputStream is = new FileInputStream(filePath)) {
            atlas = rescale(ImageIO.read(is));
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
        while (true) {
            if (x + Sprite.SIZE > atlas.getWidth()) {
                x = 0;
                y += Sprite.SIZE;
                // end of atlas
                if(y + Sprite.SIZE > atlas.getHeight())
                    return;
            }
            sprites.add(atlas.getSubimage(x, y, Sprite.SIZE, Sprite.SIZE));

            x += Sprite.SIZE;
        }
    }

    // getter

    public BufferedImage getSprite(int idx) {
        return sprites.get(idx);
    }

    public BufferedImage getSprite(Sprite s) {
        return sprites.get(s.ordinal());
    }
}