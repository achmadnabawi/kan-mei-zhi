/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */

package l1j.jrwz.server.clientpackets;

import java.util.logging.Logger;

import l1j.jrwz.server.ClientThread;
import l1j.jrwz.server.datatables.ClanTable;
import l1j.jrwz.server.model.L1Clan;
import l1j.jrwz.server.model.Instance.L1PcInstance;
import l1j.jrwz.server.serverpackets.S_Emblem;

// Referenced classes of package l1j.jrwz.server.clientpackets:
// ClientBasePacket

/**
 * 處理收到由客戶端傳來的要求血盟徽章封包
 */
public class C_Clan extends ClientBasePacket {

    private static final String C_CLAN = "[C] C_Clan";
    @SuppressWarnings("unused")
    private static Logger _log = Logger.getLogger(C_Clan.class.getName());

    public C_Clan(byte abyte0[], ClientThread client) {
        super(abyte0);
        int clanId = readD();

        L1PcInstance pc = client.getActiveChar();
        L1Clan clan = ClanTable.getInstance().getTemplate(clanId);
        // String name = clan.getClanName();
        pc.sendPackets(new S_Emblem(clan.getClanId()));
    }

    @Override
    public String getType() {
        return C_CLAN;
    }

}
