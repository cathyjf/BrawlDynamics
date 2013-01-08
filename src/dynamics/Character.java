/**
 * A basic Super Smash Bros. Brawl physics simulation Applet.
 * Copyright (C) 2009  Cathy Fitzpatrick <cathy@cathyjf.com>
 * Created in January 2009.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 **/

package dynamics;
import java.util.*;

/**
 *
 * @author Cathy
 */
public class Character {

    private static Map<String, Character> m_map
            = new HashMap<String, Character>();
    
    private int m_fallAcceleration;
    private int m_topFallSpeed;
    
    private Character(String name, int fa, int tfs) {
        m_fallAcceleration = (int)(fa * 1.3f);
        m_topFallSpeed = tfs;
        m_map.put(name, this);
    }
    
    public int getFallAcceleration() {
        return m_fallAcceleration;
    }
    
    public int getTopFallSpeed() {
        return m_topFallSpeed;
    }
    
    public static Character getCharacter(String name) {
        return m_map.get(name);
    }
    
    public static Collection<String> getCharacterList() {
        return m_map.keySet();
    }
    
    static {
        new Character("Bowser", 76, 678);
        new Character("Charizard", 53, 657);
        new Character("Dedede", 52, 952);
        new Character("Diddy", 62, 702);
        new Character("DK", 48, 771);
        new Character("Falco", 89, 832);
        new Character("Falcon", 77, 897);
        new Character("Fox", 176, 890);
        new Character("Mr. Game & Watch", 40, 607);
        new Character("Ganon", 76, 801);
        new Character("Ice Climbers", 43, 589);
        new Character("Ike", 51, 806);
        new Character("Ivysaur", 34, 658);
        new Character("Jigglypuff", 9, 481);
        new Character("Kirby", 22, 588);
        new Character("Link", 58, 781);
        new Character("Lucario", 24, 589);
        new Character("Lucas", 60, 669);
        new Character("Luigi", 27, 597);
        new Character("Mario", 40, 626);
        new Character("Mario", 40, 626);
        new Character("Marth", 30, 731);
        new Character("Meta Knight", 67, 679);
        new Character("Ness", 35, 641);
        new Character("Olimar", 21, 639);
        new Character("Peach", 25, 517);
        new Character("Pikachu", 56, 734);
        new Character("Pit", 40, 692);
        new Character("R.O.B.", 27, 588);
        new Character("Samus", 18, 522);
        new Character("Sheik", 128, 772);
        new Character("Snake", 46, 846);
        new Character("Sonic", 53, 712);
        new Character("Squirtle", 82, 639);
        new Character("Toon Link", 34, 629);
        new Character("Wario", 52, 681);
        new Character("Wolf", 114, 878);
        new Character("Yoshi", 38, 630);
        new Character("Zelda", 30, 588);
        new Character("Zero Suit Samus", 58, 703);
    }
    
}
