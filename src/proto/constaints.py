
VAR_TYPE_MAP = {
    "string": "String",
    "int32": "int",
    "enum": "enum",
}

VARIABLE_BASIC_TYPE_LIST = [
    "string",
    "int32",
    'int64',
    'bool',
    'double',
    "enum",
    'repeated'
]

VARIABLE_TYPE_MAP = {
    'repeated': 'List',
    'map': "Map"
}

VALIDATION_ALL_TO_CHECK_METHOD_MAP = {
    # 'null', # don't need null any more.
    'has': "Has",
    'min': "Min",
    'max': "Max",
    'strEmpty': "StringEmpty",
    'regex': "Regex",
    'strMin': "StringMin",
    'strMax': "StringMax",
    'strPrefix': "StringPrefix",
    'strSuffix': "StringSuffix",
    'strContains': "StringContains",
    'listMax': "ListMax",
    'listMin': "ListMin",
    'mapMin': "MapMin",
    'mapMax': "MapMax",
}

VALIDATION_NO_PARAM_LIST = [
    # 'null',
    'has',
    'strEmpty'
]
