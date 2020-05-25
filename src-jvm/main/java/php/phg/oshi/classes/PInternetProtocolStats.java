package php.phg.oshi.classes;

import oshi.software.os.InternetProtocolStats;
import php.phg.oshi.OSHIExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.HashMap;
import java.util.Map;

@Reflection.Name("InternetProtocolStats")
@Reflection.Namespace(OSHIExtension.NS)
public class PInternetProtocolStats extends BaseWrapper<InternetProtocolStats> {
    public PInternetProtocolStats(Environment env, InternetProtocolStats wrappedObject) {
        super(env, wrappedObject);
    }

    public PInternetProtocolStats(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    protected Map<String, Long> tcpStatsToMap(InternetProtocolStats.TcpStats stats) {
        return new HashMap<String, Long>() {{
            put("connectionsEstablished", stats.getConnectionsEstablished());
            put("connectionsActive", stats.getConnectionsActive());
            put("connectionsPassive", stats.getConnectionsPassive());
            put("connectionFailures", stats.getConnectionFailures());
            put("connectionsReset", stats.getConnectionsReset());
            put("segmentsSent", stats.getSegmentsSent());
            put("segmentsReceived", stats.getSegmentsReceived());
            put("segmentsRetransmitted", stats.getSegmentsRetransmitted());
            put("inErrors", stats.getInErrors());
            put("outResets", stats.getOutResets());
        }};
    }

    protected Map<String, Long> udpStatsToMap(InternetProtocolStats.UdpStats stats) {
        return new HashMap<String, Long>() {{
            put("datagramsSent", stats.getDatagramsSent());
            put("datagramsReceived", stats.getDatagramsReceived());
            put("datagramsNoPort", stats.getDatagramsNoPort());
            put("datagramsReceivedErrors", stats.getDatagramsReceivedErrors());
        }};
    }

    @Reflection.Signature
    public Map<String, Long> getTCPv4Stats() {
        return tcpStatsToMap(getWrappedObject().getTCPv4Stats());
    }

    @Reflection.Signature
    public Map<String, Long> getTCPv6Stats() {
        return tcpStatsToMap(getWrappedObject().getTCPv6Stats());
    }

    @Reflection.Signature
    public Map<String, Long> getUDPv4Stats() {
        return udpStatsToMap(getWrappedObject().getUDPv4Stats());
    }

    @Reflection.Signature
    public Map<String, Long> getUDPv6Stats() {
        return udpStatsToMap(getWrappedObject().getUDPv6Stats());
    }
}
