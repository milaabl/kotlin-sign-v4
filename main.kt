fun main() {
	//  private key
	val privateKey = "0...";

	// Message data
	val message = """
		{"types":{"EIP712Domain":[{"name":"name","type":"string"},{"name":"version","type":"string"},{"name":"chainId","type":"uint256"},{"name":"verifyingContract","type":"address"}],"OrderComponents":[{"name":"offerer","type":"address"},{"name":"zone","type":"address"},{"name":"offer","type":"OfferItem[]"},{"name":"consideration","type":"ConsiderationItem[]"},{"name":"orderType","type":"uint8"},{"name":"startTime","type":"uint256"},{"name":"endTime","type":"uint256"},{"name":"zoneHash","type":"bytes32"},{"name":"salt","type":"uint256"},{"name":"conduitKey","type":"bytes32"},{"name":"counter","type":"uint256"}],"OfferItem":[{"name":"itemType","type":"uint8"},{"name":"token","type":"address"},{"name":"identifierOrCriteria","type":"uint256"},{"name":"startAmount","type":"uint256"},{"name":"endAmount","type":"uint256"}],"ConsiderationItem":[{"name":"itemType","type":"uint8"},{"name":"token","type":"address"},{"name":"identifierOrCriteria","type":"uint256"},{"name":"startAmount","type":"uint256"},{"name":"endAmount","type":"uint256"},{"name":"recipient","type":"address"}]},"primaryType":"OrderComponents","domain":{"name":"Seaport","version":"1.5","chainId":"137","verifyingContract":"0x00000000000000ADc04C56Bf30aC9d3c0aAF14dC"},"message":{"offerer":"0x54ffab13A4852F81e2feB184918c115604b7bfbA","offer":[{"itemType":"3","token":"0x44b3f42e2BF34F62868Ff9e9dAb7C2F807ba97Cb","identifierOrCriteria":"45","startAmount":"1","endAmount":"1"}],"consideration":[{"itemType":"0","token":"0x0000000000000000000000000000000000000000","identifierOrCriteria":"0","startAmount":"925000000000000000","endAmount":"925000000000000000","recipient":"0x54ffab13A4852F81e2feB184918c115604b7bfbA"},{"itemType":"0","token":"0x0000000000000000000000000000000000000000","identifierOrCriteria":"0","startAmount":"25000000000000000","endAmount":"25000000000000000","recipient":"0x0000a26b00c1F0DF003000390027140000fAa719"},{"itemType":"0","token":"0x0000000000000000000000000000000000000000","identifierOrCriteria":"0","startAmount":"50000000000000000","endAmount":"50000000000000000","recipient":"0x99F1117F13e072b299942037E6A5d1469912B47A"}],"startTime":"1710071322","endTime":"1712749722","orderType":"1","zone":"0x0000000000000000000000000000000000000000","zoneHash":"0x0000000000000000000000000000000000000000000000000000000000000000","salt":"24446860302761739304752683030156737591518664810215442929800495252339539996469","conduitKey":"0x0000007b02230091a7ed01230072f7006a004d60a8d4e71d599b8104250f0000","totalOriginalConsiderationItems":"3","counter":"0"}}
	""".trimIndent()

	// Parse your private key to Credentials
	val credentials = Credentials.create(privateKey)

	val hash = StructuredDataEncoder(message).hashStructuredData().clone()

	val signature = Sign.signMessage(hash, credentials.ecKeyPair, false)

println(Numeric.toHexString(signature.r+signature.s+signature.v))
}