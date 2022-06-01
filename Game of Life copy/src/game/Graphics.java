package game;

import javax.swing.ImageIcon;

public enum Graphics {

        HOG("HogRider.png");

        private ImageIcon _img;

        public ImageIcon getImage(){ return _img; }

        private Graphics(String fName) {
            _img = new ImageIcon(getClass().getResource(fName));
        }

}
