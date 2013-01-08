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

/**
 *
 * @author Cathy
 */
public class Dynamics {

    public static int LAUNCH_RESISTANCE_FORCE = 115;
    public static double BLOCKS_CONVERSION = /*.00010062893081761f*/ 1.0f;
    
    public static int[] getVelocity(int launchForce, double angle, int g,
            int topFallSpeed, int frame) {
        int launchSpeed = launchForce - LAUNCH_RESISTANCE_FORCE * frame;
        if (launchSpeed < 0) {
            launchSpeed = 0;
        }
        int x = (int)(launchSpeed * Math.cos(angle));
        int fallSpeed = g * frame;
        if (fallSpeed > topFallSpeed) {
            fallSpeed = topFallSpeed;
        }
        int y = (int)(launchSpeed * Math.sin(angle)) - fallSpeed;
        return new int[] { x, y };
    }
    
    public static void main(String params[]) {
        double sx = 0, sy = 0;
        double c = 0.00010062893081761f;
        int frame = 0;
        Character lucas = Character.getCharacter("Dedede");
        do {
            ++frame;
            int[] v = getVelocity(6000, Math.PI/4,
                    lucas.getFallAcceleration(),
                    lucas.getTopFallSpeed(), frame);
            sx += v[0];
            sy += v[1];
            System.out.println("(" + Math.round(sx * c * 100) / 100.0
                    + ", " + Math.round(sy * c * 100) / 100.0 + ")");
        } while (sy > 0);
    }
    
}
