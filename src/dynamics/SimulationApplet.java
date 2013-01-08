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
import javax.swing.*;

/**
 *
 * @author Cathy
 */
public class SimulationApplet extends JApplet {

    SimulationPanel m_p;
    
    @Override
    public void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Failed to set look and feel");
        }
        
        m_p = new SimulationPanel();
        getContentPane().add(m_p);
    }
    
    @Override
    public void destroy() {
        getContentPane().remove(m_p);
    }
    
    @Override
    public void start() {

    }
    
    @Override
    public void stop() {
        m_p.stopRunning();
    }
    
}
